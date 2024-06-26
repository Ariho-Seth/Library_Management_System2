document.addEventListener("DOMContentLoaded", function(){
    const theLevelElement = document.getElementById("theLevel");
    const myClassDropDown = document.getElementById("theClass");
    
    function updateElement(){
        const theLevelValue = theLevelElement.value;
        myClassDropDown.innerHTML ="";
        if(theLevelValue==="advanced"){
            
            const optionA = document.createElement("option");
            optionA.value= "classFive";
            optionA.text= "S.5"
            myClassDropDown.appendChild(optionA);
            
            const optionB = document.createElement("option");
            optionB.value= "classSix";
            optionB.text= "S.6"
            myClassDropDown.appendChild(optionB);
                            
        }else{
            
            const option1 = document.createElement("option");
            option1.value= "classOne";
            option1.text= "S.1"
            myClassDropDown.appendChild(option1);
            
            const option2 = document.createElement("option");
            option2.value= "classTwo";
            option2.text= "S.2"
            myClassDropDown.appendChild(option2);
            
            const option3 = document.createElement("option");
            option3.value= "classThree";
            option3.text= "S.3"
            myClassDropDown.appendChild(option3);
            
            const option4 = document.createElement("option");
            option4.value= "classFour";
            option4.text= "S.4"
            myClassDropDown.appendChild(option4);
            
            }
        }
        updateElement();
        theLevelElement.addEventListener("change", updateElement)
    });