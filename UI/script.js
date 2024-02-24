function showAdditionalInfo() {
    document.getElementById("additionalInfo").style.display = "block";
    return false; // Prevent form submission
}

function toggleInputField() {
    var inputField = document.getElementById("inputField");
    var sectionSelect = document.getElementById("section");
    inputField.style.display = (sectionSelect.value === "yes") ? "block" : "none";
}