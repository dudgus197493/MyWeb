window.addEventListener("load", function(){
    const section = document.querySelector("main");
    const clockRow = section.querySelector(".main_row:first-child .main_row-clock");
    const helloRow = section.querySelector(".main_row-hello");
    const amPm =section.querySelector(".am-pm");
    const clockButton = section.querySelector(".clock_button");
    const clockSwitch = section.querySelector(".clock_switch-label");
    const clockCheckBox = section.querySelector("#clock_switch")
    let btnChecked = true;
    clockButton.onclick = function() {          // clock arrow-box visibility function
        const arrow_menu = document.querySelector(".clock-arrow_menu");
        let classes = arrow_menu.classList;
        if(classes.contains("js-act")) {
            classes.remove("js-act");
        } else {
            classes.add("js-act");
        }
    }
    clockSwitch.onclick = function() {
        btnChecked = clockCheckBox.checked;
        console.log(btnChecked);
    }

    function printHello(hour) {
        if(hour < 7) {
            helloRow.textContent = "Good night!, tonic!";
        } else if (hour < 12) {
            helloRow.textContent = "Good morning!, tonic!";
        } else if (hour < 18 ){
            helloRow.textContent = "Good afternoon!, tonic!";
        } else if (hour < 22) {
            helloRow.textContent = "Good evening!, tonic!";
        } else {
            helloRow.textContent = "Good night!, tonic!";
        }
    }
    function printAmPm(hour){
        if (hour < 12){
            amPm.textContent = "AM";
        } else {
            amPm.textContent = "PM";
        }
    }
    function printTime(){
        let today = new Date();

        let tmpHour = today.getHours();
        let tmpMinute = today.getMinutes();
        
        
        if(btnChecked == true) {
            let hour = tmpHour > 12 ? (tmpHour - 12).toString().padStart(2, '0') : tmpHour.toString();
            // let minute = tmpMinute < 10 ? tmpMinute.toString().padStart(2, '0') : tmpMinute.toString();
            let minute = tmpMinute.toString().padStart(2, '0');
            clockRow.textContent = `${hour}:${minute}`;
        } else {
            clockRow.textContent = `${tmpHour.toString().padStart(2, '0')}:${tmpMinute.toString().padStart(2, '0')}`
        }
        
        printAmPm(tmpHour);
        printHello(tmpHour);
    }
    
    printTime();
    setInterval(printTime, 1000);
})



// clockRow.textContent = "12:00";
