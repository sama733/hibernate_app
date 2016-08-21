function addRow() {

    var grantName = document.getElementById("grantName");
    var minPeriod = document.getElementById("minPeriod");
    var maxPeriod = document.getElementById("maxPeriod");
    var minCost = document.getElementById("minCost");
    var maxCost = document.getElementById("maxCost");


    var table = document.getElementById("grantConditionsTable");
    var rowCount = table.rows.length;
    if (rowCount == 0) {
        addHeader();
    } else {
        deleteFooter();
    }
    if (grantName.value != "" && minCost.value != "" && maxCost.value != "" && minPeriod.value != "" && maxPeriod != "") {
        rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        row.insertCell(0).innerHTML = (rowCount).toString();
        row.insertCell(1).innerHTML = '<input type="text" name="grantName' + rowCount + '" value="' + grantName.value + '" readonly>';
        row.insertCell(2).innerHTML = '<input type="text" name="minPeriod' + rowCount + '" value="' + minPeriod.value + '" readonly>';
        row.insertCell(3).innerHTML = '<input type="text" name="maxPeriod' + rowCount + '" value="' + maxPeriod.value + '" readonly>';
        row.insertCell(4).innerHTML = '<input type="text" name="minCost' + rowCount + '" value="' + minCost.value + '" readonly>';
        row.insertCell(5).innerHTML = '<input type="text" name="maxCost' + rowCount + '" value="' + maxCost.value + '" readonly>';
        row.insertCell(6).innerHTML = '<button class="button" onClick="deleteRow(this)">حذف</button>';
    }
    addFooter();
    
    document.getElementById("grantName").value = "";
    document.getElementById("minPeriod").value = "";
    document.getElementById("maxPeriod").value = "";
    document.getElementById("minCost").value = "";
    document.getElementById("maxCost").value = "";

}
function addHeader() {
    var table = document.getElementById("grantConditionsTable");
    var rowCount = table.rows.length;
    var headerRow = table.insertRow(rowCount);
    var headerCell = document.createElement("TH");
    headerCell.innerHTML = "ردیف";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "نام شرط";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "حداقل مدت قرارداد";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "حداکثر مدت قرارداد";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "حداقل مبلغ قرارداد";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "حداکثر مبلغ قرارداد";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "عملیات";
    headerRow.appendChild(headerCell);

}

function deleteRow(obj) {

    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("grantConditionsTable");
    table.deleteRow(index);
    deleteFooter();
    var rowCount = table.rows.length;
    if (rowCount == 1) {
        table.innerHTML = "";
    } else {
        for (var i = 1; i < rowCount; i++) {
            table.rows[i].cells[0].innerHTML = i.toString();
        }
        addFooter();
    }
}

function addFooter() {
    var table = document.getElementById("grantConditionsTable");
    if (!table.tFoot) {
        var footer = table.createTFoot();
        var footerRow = footer.insertRow(0);
        var cell = footerRow.insertCell(0);
        cell.innerHTML = '<input type="submit" class="button" value="ثبت"> <input type="text" name="rowCount" value="' + table.rows.length + '" hidden>';
    }
}

function deleteFooter() {
    var table = document.getElementById("grantConditionsTable");
    if (table.tFoot) {
        table.deleteTFoot();
    }
}