/**
 * 
 */

var search = document.getElementById("landing-filter")
var buttons = document.querySelectorAll(".route-name")


	

buttons.forEach(x => {
	
	x.addEventListener("click", (e) =>{

		window.location.href="/routes?busName=" + e.target.innerText
		
	})
})


search.addEventListener("keyup", (e) =>{
	search = e.target.value;
	
	buttons.forEach(y => {
		btnText = y.innerText
		
		if (!btnText.startsWith(search.toUpperCase())){
			y.classList.add("hide-btn")
			
		}
		else{
			y.classList.remove("hide-btn")
		}
		
		changeFoot();
		
	})

	
})


function changeFoot(){
	
	var foot = document.getElementById("main-footer")
	var hiddenButtonNum = document.querySelectorAll(".hide-btn").length
	
	var visibleButtonNum = buttons.length - hiddenButtonNum

	if (visibleButtonNum < 6)
		{
			foot.classList.add("long-footer")

		}	
		else{
			foot.classList.remove("long-footer")
		}	

	
}
