<?php
//phpinfo();
function do_call($host, $port, $request) {
   
    $fp = fsockopen($host, $port, $errno, $errstr);
    $query = "POST /test.php HTTP/1.0\nUser_Agent: My Egg Client\nHost: ".$host."\nContent-Type: text/xml\nContent-Length: ".strlen($request)."\n\n".$request."\n";
    if (!fputs($fp, $query, strlen($query))) {
        $errstr = "Write error";
        return 0;
    }

    $contents = '';
    while (!feof($fp)) {
        $contents .= fgets($fp);
    }

    fclose($fp);
    return $contents;
}
$host = '127.0.0.1';
$port = 80;
$request = xmlrpc_encode_request('get_item_category','Items');

$response = do_call($host, $port, $request);

$res=xmlrpc_decode($response);
$xml=(substr($response, strpos($response, "\r\n\r\n")+4));

$phpvars = xmlrpc_decode ($xml);
print $phpvars;
print $response;
/* do something with $response, e.g. print it */
?> 
