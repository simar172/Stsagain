document.querySelector(".subs").disabled=true;
document.querySelector(".inp").addEventListener("input",()=>{
   let a=document.querySelector(".inp").value;
   console.log(a);
   if(a.length<5){
    document.querySelector(".inv").textContent="Password length should be greater than 5!";
    document.querySelector(".subs").disabled=true;
   }
   else{
    document.querySelector(".inv").textContent=""
    document.querySelector(".subs").disabled=false;
   }
})