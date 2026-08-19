/* =====================================
   SELECT HTML ELEMENTS
   ===================================== */

// getElementById()

const nameInput =
    document.getElementById("name");

const regInput =
    document.getElementById("regno");

const departmentInput =
    document.getElementById("department");

const yearInput =
    document.getElementById("year");

const displayBtn =
    document.getElementById("displayBtn");

const profileContainer =
    document.getElementById("profileContainer");


// querySelector()

const form =
    document.querySelector("#studentForm");


/* =====================================
   DISPLAY PROFILE
   ===================================== */

displayBtn.addEventListener("click", function() {

    // Read form values

    const name = nameInput.value.trim();
    const regno = regInput.value.trim();
    const department = departmentInput.value;
    const year = yearInput.value;


    // Validate fields

    if (
        name === "" ||
        regno === "" ||
        department === "" ||
        year === ""
    ) {

        alert("Please fill all the fields.");

        return;
    }


    /* =================================
       CREATE PROFILE DYNAMICALLY
       ================================= */

    // createElement()

    const profile =
        document.createElement("div");

    profile.classList.add("profile");
    profile.classList.add("highlight");


    // Profile top section

    const profileTop =
        document.createElement("div");

    profileTop.classList.add("profile-top");


    // Avatar

    const avatar =
        document.createElement("div");

    avatar.classList.add("avatar");

    avatar.textContent =
        name.substring(0, 2).toUpperCase();


    // Student information

    const titleArea =
        document.createElement("div");


    const label =
        document.createElement("p");

    label.classList.add("profile-label");

    label.textContent = "REGISTERED STUDENT";


    const studentName =
        document.createElement("h3");

    studentName.textContent = name;


    titleArea.appendChild(label);
    titleArea.appendChild(studentName);

    profileTop.appendChild(avatar);
    profileTop.appendChild(titleArea);


    /* =================================
       DETAILS
       ================================= */

    const details =
        document.createElement("div");

    details.classList.add("details");


    // Register number

    const regDetail =
        createDetail(
            "Register Number",
            regno
        );


    // Department

    const deptDetail =
        createDetail(
            "Department",
            department
        );


    // Year

    const yearDetail =
        createDetail(
            "Year of Study",
            year
        );


    details.appendChild(regDetail);
    details.appendChild(deptDetail);
    details.appendChild(yearDetail);


    /* =================================
       REMOVE BUTTON
       ================================= */

    const removeBtn =
        document.createElement("button");

    removeBtn.textContent =
        "Remove Profile";

    removeBtn.classList.add("remove-btn");


    // addEventListener()

    removeBtn.addEventListener(
        "click",
        function() {

            // element removal

            profile.remove();

            // Show empty state again

            showEmptyState();

        }
    );


    /* =================================
       BUILD PROFILE
       ================================= */

    profile.appendChild(profileTop);

    profile.appendChild(details);

    profile.appendChild(removeBtn);


    // Display generated profile

    profileContainer.innerHTML = "";

    profileContainer.appendChild(profile);

});


/* =====================================
   CREATE DETAIL FUNCTION
   ===================================== */

function createDetail(labelText, valueText) {

    const detail =
        document.createElement("div");

    detail.classList.add("detail");


    const label =
        document.createElement("span");

    label.textContent = labelText;


    const value =
        document.createElement("strong");

    value.textContent = valueText;


    detail.appendChild(label);

    detail.appendChild(value);


    return detail;
}


/* =====================================
   EMPTY PROFILE
   ===================================== */

function showEmptyState() {

    profileContainer.innerHTML = "";

    const empty =
        document.createElement("div");

    empty.classList.add("empty-state");


    const icon =
        document.createElement("div");

    icon.classList.add("empty-icon");

    icon.textContent = "👤";


    const heading =
        document.createElement("h3");

    heading.textContent =
        "No Profile Yet";


    const message =
        document.createElement("p");

    message.textContent =
        "Enter your details and click Display Profile to preview your student profile.";


    empty.appendChild(icon);

    empty.appendChild(heading);

    empty.appendChild(message);

    profileContainer.appendChild(empty);

}
/* =====================================
   SUBMIT EVENT
   ===================================== */

form.addEventListener("submit", function(event) {

    // Prevent page reload

    event.preventDefault();


    // Check whether profile has been created

    const profile =
        document.querySelector(".profile");


    if (!profile) {

        alert(
            "Please display your profile before submitting."
        );

        return;
    }


    alert(
        "Student registration submitted successfully!"
    );

});