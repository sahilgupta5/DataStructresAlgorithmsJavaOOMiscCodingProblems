function insertToList() {
  var listElement = document.createElement("li");
  var inputValue = document.getElementById("lInput").value;
  var textNode = document.createTextNode(inputValue);
  listElement.appendChild(textNode);
  /* No text should be inserted if the text field is empty on performing insertion */
  if (inputValue === '') {
    alert("Please provide an input!");
  } else {
    document.getElementById("unorderedList").appendChild(listElement);
  }
}