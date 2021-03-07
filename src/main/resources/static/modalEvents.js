function openAddItemForm() {

    document.getElementById("myForm").style.display = "block";
}

function closeAddItemForm() {
    clearDataFromAddItemForm();

    document.getElementById("myForm").style.display = "none";
}
function openRemoveItemForm() {
    document.getElementById("removeItemForm").style.display = "block";
}

function closeRemoveItemForm() {
    document.getElementById("removeItemForm").style.display = "none";
}
//TODO
function submitNewItemViaForm(id) {
    //parse
    let item = getItemDetialsFromAddItemForm();
    //make request
    addItem(item)
        .then(data => {
            closeAddItemForm();
            clickRefreshButtonMainTable()

        })
        .catch(err => {
            displayErrorMessage(id,err.message)
        })
    //handle reply

}

function submitRemoveItem(id) {
    //parse
    let item = getItemDetailsFromRemoveItemForm();
    //make request
    removeItemApiRequest(item)
        .then(data => {
            console.log('removeItemApiRequest:',data)
            clearDataFromAddItemForm();
            clickRefreshButtonMainTable()
            closeRemoveItemForm();

        })
        .catch(err => {
            displayErrorMessage(id,err.message)
        })
    //handle reply

    //parse
    //make request
    //handle reply

}