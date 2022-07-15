const MALE = "Male";
const FEMALE = "Female";
const JAVA_SKILL = "JAVA";
const HTML_SKILL = "HTML";
const CSS_SKILL = "CSS";
const GREEN_BORDER = "solid 1px green";
const RED_BORDER = "solid 1px red";
const DUPLICATE_EMAIL_ID_ERROR = "Duplicate Email ID!";
const INVALID_URL_ERROR = "Invalid website URL!";
const INVALID_IMAGE_URL_ERROR = "Invalid Image URL!";
const INVALID_EMAIL_ID_ERROR = "Invalid Email ID!";
const IVALID_NAME_ERROR = "Enter a valid Name!";
const VISIBLE = "visible";
const HIDDEN = "hidden";
const GENDER_ERROR = "Select Male or Female";
const SKILLS_ERROR = "Please Select Skills";

window.onload = clear();
function clear() {
    localStorage.clear();
}

function fadeIn() {
    var fade = document.getElementById("tbody");
    var opacity = 0;
    var intervalID = setInterval(function () {
        if (opacity < 1) {
            opacity = opacity + 0.1
            fade.style.opacity = opacity;
        } else {
            clearInterval(intervalID);
        }
    }, 70);
}

let skills = [];
function getSkills() {
    skills = [];
    if (document.getElementById("java").checked) {
        skills.push(JAVA_SKILL)
    }
    if (document.getElementById("html").checked) {
        skills.push(HTML_SKILL)
    }
    if (document.getElementById("css").checked) {
        skills.push(CSS_SKILL);
    }
    return skills;
}

function getGender() {
    if (document.getElementById("male").checked) {
        return MALE;
    }
    else {
        return FEMALE;
    }
}

$("#add-user").on("click", function (event) {
    event.preventDefault();
    let formData = JSON.parse(localStorage.getItem('formData')) || [];
    formData.push({
        // Capture user inputs and store them into variables $("#name-input").val().trim(),
        name: document.getElementById('name-input').value,
        email: document.getElementById('email-input').value,
        website: document.getElementById('website-input').value,
        image: document.getElementById('image-input').value,
        gender: getGender(),
        skills: getSkills()
    });
    if (validateName() && validateEmail() && validateWebsite() && validateImage && validateSkills() &&
        validateGender() && validateDuplicateEmail()) {
        localStorage.setItem('formData', JSON.stringify(formData));
        document.querySelector('form').reset();
        console.log(localStorage.getItem('formData'));
        displayData();
    }
});

$("#clear-fields").on("click", function (event) {
    document.querySelector('form').reset();
});

function displayData() {
    console.log(localStorage.getItem('formData'));
    if (localStorage.getItem('formData')) {
        var output = document.querySelector("tbody");
        output.innerHTML = "";
        JSON.parse(localStorage.getItem('formData')).forEach(data => {
            output.innerHTML += `
                <tr>
                    <td class="border-end">
                        <div>
                            <p class="m-0"><b>${data.name}</b></p>
                            <p class="m-0">${data.gender}</p>
                            <p class="m-0">${data.email}</p>
                            <a class="m-0" target="_blank" href=${data.website}>
                               <u> ${data.website} </u></a>
                                <p class="m-0">${data.skills}</p>
                                </div>
                                </td>
                    <td>
                        <div class="h-100 w-100">
                            <img src=${data.image} class="img-fluid w-100 h-100 border rounded"
                alt="image"/>
                </div>
                </td>
                </tr>
        `;
        }
        )
    };
    fadeIn();
}

function validateName() {
    var returnValue = true;
    var nameborder = document.getElementById('name-input');
    var name = document.getElementById('name-input').value;
    if (name.trim() == "" || name == 0) {
        nameborder.style.border = RED_BORDER;
        document.getElementById("user-name").innerHTML = IVALID_NAME_ERROR;
        document.getElementById("user-name").style.visibility = VISIBLE;
        returnValue = false;
    } else {
        nameborder.style.border = GREEN_BORDER;
        document.getElementById("user-name").style.visibility = HIDDEN;
    }
    return returnValue;
}

function validateEmail() {
    var returnValue = true;
    var email = document.getElementById('email-input').value;
    var emailborder = document.getElementById('email-input');
    var validRegex = /^[a-zA-Z0-9.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)$/;

    if (!email.match(validRegex) || email.trim() == "") {
        emailborder.style.border = RED_BORDER;
        document.getElementById("user-email").innerHTML = INVALID_EMAIL_ID_ERROR;
        document.getElementById("user-email").style.visibility = VISIBLE;
        returnValue = false;
    } else {
        emailborder.style.border = GREEN_BORDER;
        document.getElementById("user-email").style.visibility = HIDDEN;
    }
    return returnValue;
}

function validateImage() {
    var imageborder = document.getElementById('image-input');
    var image = document.getElementById('image-input').value;
    var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
    var returnValue = true;
    if (!allowedExtensions.exec(image) || image.trim() == "") {
        imageborder.style.border = RED_BORDER;
        document.getElementById("user-image").innerHTML = INVALID_IMAGE_URL_ERROR;
        document.getElementById("user-image").style.visibility = VISIBLE;
        returnValue = false;
    } else {
        imageborder.style.border = GREEN_BORDER;
        document.getElementById("user-image").style.visibility = HIDDEN;
    }
    return returnValue;
}

function validateWebsite() {
    var returnValue = true;
    var websiteborder = document.getElementById('website-input');
    var website = document.getElementById('website-input').value;
    var URLpattern = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
    if (!URLpattern.test(website) || website.trim() == "") {
        websiteborder.style.border = RED_BORDER;
        document.getElementById("user-website").innerHTML = INVALID_URL_ERROR;
        document.getElementById("user-website").style.visibility = VISIBLE;
        returnValue = false;
    } else {
        websiteborder.style.border = GREEN_BORDER;
        document.getElementById("user-website").style.visibility = HIDDEN;
    }
    return returnValue;
}

function validateSkills() {
    var returnValue = true;
    var cbox1 = document.getElementById("java").checked;
    var cbox2 = document.getElementById("html").checked;
    var cbox3 = document.getElementById("css").checked;
    if (cbox1 == false && cbox2 == false && cbox3 == false) {
        alert(SKILLS_ERROR);
        returnValue = false;
    }
    return returnValue;
}

function validateGender() {
    var returnValue = true;
    var male = document.getElementById("male").checked;
    var female = document.getElementById("female").checked;
    if (male == false && female == false) {
        alert(GENDER_ERROR);
        returnValue = false;
    }
    return returnValue;
}

function validateDuplicateEmail() {
    var returnValue = true;
    var email = document.getElementById('email-input').value;
    var emailborder = document.getElementById('email-input');
    let user_records = new Array();
    user_records = JSON.parse(localStorage.getItem("formData")) ? JSON.parse(localStorage.getItem("formData")) : []
    if (user_records.some((v) => { return v.email == email })) {
        emailborder.style.border = RED_BORDER;
        document.getElementById("user-email").innerHTML = DUPLICATE_EMAIL_ID_ERROR;
        document.getElementById("user-email").style.visibility = VISIBLE;
        returnValue = false;
    } else {
        emailborder.style.border = GREEN_BORDER;
        document.getElementById("user-email").style.visibility = HIDDEN;
    }
    return returnValue;
}