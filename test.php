<?php

function get_category($method, $params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	$result = pg_exec($link, "select * from category");
	$content=pg_fetch_all($result);
	pg_close($link);
	return $content;
}

function get_items_with_category($method, $params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	$query="select p_id,p_label,p_desc,p_image,p_price,c_label from product natural join product_category natural join category where c_label='".$params[1]."'";
	$result = pg_exec($link,$query);
	$content=pg_fetch_all($result);
	pg_close($link);
	return $content;
}

function add_item($method, $params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	$query="insert into product(p_label,p_desc,p_image,p_hero,p_price) values('".$params[1]."','".$params[2]."','".$params[3]."','".$params[4]."','".$params[5]."')";
	$result = pg_exec($link,$query);
	$content=pg_fetch_all($result);
	pg_close($link);
	return array($content,"123");
}

function add_item_to_category($method,$params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	//TODO IMPLEMENT
	$ItemQuery="select p_id from product where p_label=".$params[1].";";
	$result = pg_exec($link,$query);
	$numrows = pg_numrows($result);
	$row = pg_fetch_array($result, 0);
	$p_id=$row["p_id"];

	$CategoryQuery="select c_id from category where p_label=".$params[2].";";
	$result = pg_exec($link,$query);
	$numrows = pg_numrows($result);
	$row = pg_fetch_array($result, 0);
	$c_id=$row["c_id"];

	$InsertQuery="insert into product_category(p_id,c_id) values(".$p_id.",".$c_id.");";
	$result = pg_exec($link,$query);
	$content=pg_fetch_all($result);
	pg_close($link);
	return $content;

}

function register_user($method,$params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	$register_query="insert into users(u_mail,u_pass) values('".$params[1]."','".$params[2]."')";
	$result = pg_exec($link,$register_query);
	$select_query="select u_id from users where u_mail='".$params[1]."'";
	$result = pg_exec($link,$select_query);
	$content=pg_fetch_all($result);
	pg_close($link);
	return $content;
}

function register_shopping_cart($method,$params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	$register_query = "insert into shopping_cart(u_id,sc_cost) values('".$params[1]."',0)";
	$result = pg_exec($link,$register_query);
	$select_query="select sc_id from shopping_cart where u_id='".$params[1]."'";
	$result = pg_exec($link,$select_query);
	$content = pg_fetch_all($result);
	pg_close($link);
	return $content;
}

function add_to_shopping_cart($method,$params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	// IF already exist then update otherwise insert.(no side effects)
	$update_query="update into shopping_cart_item set quantity=quantity+1 where p_id=".$params[1]." and sc_id=".$params[2];
	$result = pg_exec($link,$update_query);
	$insert_query= "insert into shopping_cart_item(p_id,sc_id,quantity) values(".$params[1].",".$params[2].",1)";
	$result = pg_exec($link,$insert_query);
	$content = pg_fetch_all($result);
	pg_close($link);
	return $content;
}

function perform_transaction($method,$params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	$query = "insert into transaction(u_id,sc_id) values(".$params[1].",".$params[2].")";
	$result = pg_exec($link,$query);
	$content = pg_fetch_all($result);
	pg_close($link);
	return $content;
}

function get_heroes($method, $params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	$query="select distinct p_hero from product";
	$result = pg_exec($link,$query);
	$content = pg_fetch_all($result);
	pg_close($link);
	return $content;
}
function get_items_by_hero_name($method,$params){
	$link = pg_connect("host=127.0.0.1 dbname=postgres user=postgres password=postgres");
	if(!$link){
		return "no database connection";
	}
	$query = "select * from product where p_hero='".$params[1]."'";
	$result = pg_exec($link,$query);
	$content = pg_fetch_all($result);
	pg_close($link);
	return $content;
}

$server = xmlrpc_server_create();

/* register the 'external' name and then the 'internal' name */
xmlrpc_server_register_method($server, "get_heroes", "get_heroes");
xmlrpc_server_register_method($server, "get_category", "get_category");
xmlrpc_server_register_method($server, "register_user", "register_user");
xmlrpc_server_register_method($server, "register_shopping_cart", "register_shopping_cart");
xmlrpc_server_register_method($server, "add_item_to_cart", "add_to_shopping_cart");
xmlrpc_server_register_method($server, "get_item_category", "get_items_with_category");
xmlrpc_server_register_method($server, "add_item", "add_item");
xmlrpc_server_register_method($server, "add_item_to_category", "add_item_to_category");

$request = $HTTP_RAW_POST_DATA; // no you don't need 'always on', and no $_POST doesn't work.

/* the parameters here are 'server, xml-string and user data'.  There's supposed to be an optional 'output options' array too, but I can't get it working :( hence header() call */
$response = xmlrpc_server_call_method($server, $request, null);
header('Content-Type: text/xml');
print $response;

xmlrpc_server_destroy($server);
?>

