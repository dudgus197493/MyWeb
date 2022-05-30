window.addEventListener("load", function(){
	var quoteList;
    let httpRequest;

    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(){
        if(httpRequest.readyState === XMLHttpRequest.DONE) {
            if(httpRequest.status === 200) {
				console.log("접속 성공!");
				quoteList = JSON.parse(httpRequest.response);
				
            } else {
                alert("Request Error!");
            }
        }
    };
    httpRequest.open("GET", "/api/quote/list", false);

    /*httpRequest.responseType = "json";*/
    httpRequest.send();
	
	console.log(quoteList[0]);
    
})