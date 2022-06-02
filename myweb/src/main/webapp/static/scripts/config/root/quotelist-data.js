window.addEventListener("load", function(){
// 최초 요청시 데이터 담기 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	console.log("script.ver3");
	let dataList;
    let httpRequest;

    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(){
        if(httpRequest.readyState === XMLHttpRequest.DONE) {
            if(httpRequest.status === 200) {
				dataList = JSON.parse(httpRequest.response);
            } else {
                alert("Request Error!");
            }
        }
    };
    httpRequest.open("GET", "/api/quote/list", false);
    /*httpRequest.responseType = "json";*/
    httpRequest.send();
    
    console.log(dataList);
// 최초 요청시 데이터 담기 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

// quoteSearchㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	let searchForm = document.querySelector(".quote-search"),
        searchInput = searchForm.querySelector("#quote-search_input"),
        searchOptions = searchForm.querySelector("#search-options");

    searchForm.onsubmit = function(e) {
        e.preventDefault();

        reqJson = new Object();
        reqJson.keyword = searchInput.value;
        reqJson.option = searchOptions.value;

        httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = function(){
            if(httpRequest.readyState === XMLHttpRequest.DONE) {
                if(httpRequest.status === 200) {
                    dataList = JSON.parse(httpRequest.response);
                    console.log(dataList);
                    init();
                    console.log("Request Success!!!");
                } else {
                    alert("Request Error!");
                }
            }
        }
        httpRequest.open("POST", "/api/quote/search", false);
         /* 요청 Header에 컨텐츠 타입은 Json으로 사전 정의 */
	    httpRequest.setRequestHeader('Content-Type', 'application/json');
	    /* 정의된 서버에 Json 형식의 요청 Data를 포함하여 요청을 전송 */
	    httpRequest.send(JSON.stringify(reqJson));

    }

// quoteSort ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	let quoteSort = document.querySelector("#quote-sort"),
        quoteCount = quoteSort.querySelector("#quote-count"),
        sortOptions = quoteSort.querySelector("#sort-options");

//  quoteList ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    let quoteList = document.querySelector("#quote-list"),
        quoteTemplate = quoteList.querySelector("template");
    
    quoteList.addEventListener("click",function(e){							   // 명언삭제 버튼 기능
        if(!(e.target.className == "quote-del" || e.target.nodeName == "I")) { // 타겟이 버튼, 아이콘 둘다 아니라면 리턴.
            return;
        }
        let parentNodeLi = e.target;
        for(; parentNodeLi.nodeName != "LI"; parentNodeLi = parentNodeLi.parentNode);	// 타겟 노드가 li가 될떄까지 부모노드 불러옴.
        let targetNumber = parentNodeLi.querySelector(".quote-number").textContent;
        let delData = dataList.splice(Number(targetNumber) - 1, 1);
        init();

        // del Controller Request
        let reqJson = new Object();
        reqJson.keyword = delData[0].engContent;

        httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = function(){
            if(httpRequest.readyState === XMLHttpRequest.DONE) {
                if(httpRequest.status === 200) {
                    alert("해당 데이터가 삭제되었습니다!");
                } else {
                    alert("Request Error!");
                }
            }
        }
        httpRequest.open("POST", "/api/quote/del", false);
         /* 요청 Header에 컨텐츠 타입은 Json으로 사전 정의 */
	    httpRequest.setRequestHeader('Content-Type', 'application/json');
	    /* 정의된 서버에 Json 형식의 요청 Data를 포함하여 요청을 전송 */
	    httpRequest.send(JSON.stringify(reqJson));
    })
    init();

    
    sortOptions.onchange = function(e){
        let value = e.target.value;
        if(value == 1) {
            return;
        } else if( value == 2) {
            ascendingEng();
            init();
        } else if(value == 3) {
            descendingEng();
            init();
        } else if(value == 4) {
            ascendingKor();
            init();
        } else {
            descendingKor();
            init();
        }
    }

    function init (){
        quoteCount.textContent = dataList.length + "개";
        quoteList.innerHTML = "";
        for(let i = 0; i<dataList.length; i++){
            let cloneNode = document.importNode(quoteTemplate.content, true);
            let quoteNumber = cloneNode.querySelector(".quote-number"),
                engContentSpan = cloneNode.querySelector(".content-eng .content"),
                korContentSpan = cloneNode.querySelector(".content-kor .content"),
                sourceSpan = cloneNode.querySelector(".source");

                quoteNumber.textContent = i + 1 + ".";
                engContentSpan.textContent = dataList[i].engContent;
                korContentSpan.textContent = dataList[i].korContent;
                sourceSpan.textContent = dataList[i].sourceSpan;
                quoteList.append(cloneNode);
        }
    }

    function ascendingEng(){
        dataList.sort(function(a, b) {
            x = a.engContent.toLowerCase();
            y = b.engContent.toLowerCase();
            if(x > y) {
                return 1;
            } else if (x < y){
                return -1;
            }
            return 0;
        })
    }
    function descendingEng(){
        dataList.sort(function(a, b) {
            x = a.engContent.toLowerCase();
            y = b.engContent.toLowerCase();
            if(x > y) {
                return -1;
            } else if (x < y){
                return 1;
            }
            return 0;
        })
    }
    function ascendingKor(){
        dataList.sort(function(a, b) {
            x = a.korContent.toLowerCase();
            y = b.korContent.toLowerCase();
            if(x > y) {
                return 1;
            } else if (x < y){
                return -1;
            }
            return 0;
        })
    }
    function descendingKor(){
        dataList.sort(function(a, b) {
            x = a.korContent.toLowerCase();
            y = b.korContent.toLowerCase();
            if(x > y) {
                return -1;
            } else if (x < y){
                return 1;
            }
            return 0;
        })
    }

})