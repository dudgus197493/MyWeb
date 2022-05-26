window.addEventListener("load", function() {
	const form = document.querySelector("form[name='root_search-frm']");
	const input = form.querySelector(".search_input");
	const engine = form.querySelector(".select_search");
	form.onsubmit = function(e){
	    e.preventDefault();
	    if(engine.value == "G") {
	        window.open("https://www.google.com/search?q=" + input.value); 
	    } else if (engine.value == "N") {
	        window.open("https://search.naver.com/search.naver?query=" + input.value);
	    } else if (engine.value == "Y") {
	        window.open("https://www.youtube.com/results?search_query=" + input.value); 
	    }
	} 
});




