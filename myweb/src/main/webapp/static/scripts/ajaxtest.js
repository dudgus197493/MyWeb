window.onload = function() {
    var httpRequest;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(){
        if(httpRequest.readyState === XMLHttpRequest.DONE) {
            if(httpRequest.status === 200) {
                var result = httpRequest.response;
                console.log(result);
                document.querySelector(".random-qte").textContent = result.engContent;
            } else {
                alert("Request Error!!");
            }
        }
    };
    httpRequest.open("GET", "/api/quote/random");

    httpRequest.responseType = "json";
    httpRequest.send();
}