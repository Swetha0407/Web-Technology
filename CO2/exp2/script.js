document.getElementById("regForm").addEventListener("submit",function(e){

e.preventDefault();

let valid=true;

clearErrors();

let name=document.getElementById("name");
let regno=document.getElementById("regno");
let email=document.getElementById("email");
let mobile=document.getElementById("mobile");
let password=document.getElementById("password");
let confirm=document.getElementById("confirm");
let department=document.getElementById("department");
let address=document.getElementById("address");

let gender=document.querySelector('input[name="gender"]:checked');

let terms=document.getElementById("terms");

let nameRegex=/^[A-Za-z ]{3,}$/;
let regRegex=/^[0-9]{6,12}$/;
let emailRegex=/^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
let mobileRegex=/^[6-9][0-9]{9}$/;
let passwordRegex=/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).{8,}$/;

if(!nameRegex.test(name.value)){
showError(name,"Enter a valid name");
valid=false;
}
else
showSuccess(name);

if(!regRegex.test(regno.value)){
showError(regno,"Invalid Register Number");
valid=false;
}
else
showSuccess(regno);

if(!emailRegex.test(email.value)){
showError(email,"Invalid Email");
valid=false;
}
else
showSuccess(email);

if(!mobileRegex.test(mobile.value)){
showError(mobile,"Invalid Mobile Number");
valid=false;
}
else
showSuccess(mobile);

if(!passwordRegex.test(password.value)){
showError(password,"Password must contain uppercase, lowercase and number");
valid=false;
}
else
showSuccess(password);

if(confirm.value!=password.value || confirm.value==""){
showError(confirm,"Passwords do not match");
valid=false;
}
else
showSuccess(confirm);

if(department.value==""){
showError(department,"Select Department");
valid=false;
}
else
showSuccess(department);

if(address.value.trim()==""){
showError(address,"Enter Address");
valid=false;
}
else
showSuccess(address);

if(!gender){
document.getElementById("genderError").innerHTML="Select Gender";
valid=false;
}

if(!terms.checked){
document.getElementById("termsError").innerHTML="Accept Terms";
valid=false;
}

if(valid){
alert("Registration Successful");
document.getElementById("regForm").reset();
}

});

function showError(input,message){

input.className="error";
input.nextElementSibling.innerHTML=message;

}

function showSuccess(input){

input.className="success";
input.nextElementSibling.innerHTML="";

}

function clearErrors(){

let inputs=document.querySelectorAll("input,select,textarea");

inputs.forEach(function(item){

item.classList.remove("error");
item.classList.remove("success");

});

document.querySelectorAll("small").forEach(function(item){

item.innerHTML="";

});

}