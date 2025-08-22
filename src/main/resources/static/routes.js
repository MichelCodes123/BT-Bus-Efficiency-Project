/**
 * 
 */

var stopDescriptions = document.querySelectorAll(".stopScoreIndicator");


stopDescriptions.forEach(x =>{
	

	var value = x.innerText;
	if (value < 1){
		x.innerText = "over 20 minutes late"
		x.classList.add("red")
	}
	else if (value < 2){
		x.innerText = "15-20 minutes late"
		x.classList.add("red")
	}
	else if (value < 3){
		x.innerText = "around 10-15 minutes late"
		x.classList.add("red")
	}
	else if (value < 4){
		x.innerText = "around 3-10 minutes late"
		x.classList.add("orange")
	}
	else if (value < 4.5){
		x.innerText = "a few minutes late"
		x.classList.add("green")
	}
	else{
		x.innerText = "on time"
		x.classList.add("green")
	}
	
})

var totalDesc = document.getElementById("totalScoreColor")
var longerDesc = document.getElementById("penaltyIndicator")


var value = totalDesc.innerText;
if (value < 1){
	longerDesc.innerText = "over 20 minutes late"
	longerDesc.classList.add("red")
	totalDesc.classList.add("red")
}
else if (value < 2){
	longerDesc.innerText = "15-20 minutes late"
	longerDesc.classList.add("red")
	totalDesc.classList.add("red")
}
else if (value < 3){
	longerDesc.innerText = "around 10-15 minutes late"
	longerDesc.classList.add("red")
	totalDesc.classList.add("red")
}
else if (value < 4){
	longerDesc.innerText = "around 3-10 minutes late"
	longerDesc.classList.add("orange")
	totalDesc.classList.add("orange")
}
else if (value < 4.5){
	longerDesc.innerText = "a few minutes late"
	longerDesc.classList.add("green")
	totalDesc.classList.add("green")
}
else{
	longerDesc.innerText = "on time"
	longerDesc.classList.add("green")
	totalDesc.classList.add("green")
}


