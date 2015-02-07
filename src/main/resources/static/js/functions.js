function dodajStavku(){
    var stavkeCont = document.getElementById('stavkeCont');
    var novaStavka = document.createElement('div');
    
    novaStavka.innerHTML = buildStavkaHtml();
    stavkeCont.appendChild(novaStavka);
}

function buildStavkaHtml(){
    var counterElement = document.getElementById('counter');
    var counter = document.getElementById('counter').value;
    if(counter !== ''){
        counter++;
        counterElement.value = counter;
    } else {
        counterElement.value = '0';
    }
    
    counter++;
    
    var stavka = "<div class='form-group'><label>Redni broj: "+counter+"</label></div>";
    stavka += "<div class='form-group'><label>Naziv robe ili usluge</label><input type='text' class='form-control' placeholder='Unesite naziv...' name='invoiceRecordList[" + (counter - 1) + "].merchOrServiceName'/></div>";
    stavka += "<div class='form-group'><label>Kolicina</label><input type='text' class='form-control' placeholder='Unesite kolicinu...' name='invoiceRecordList[" + (counter - 1) + "].amount'/></div>";
    stavka += "<div class='form-group'><label>Jedinica mere</label><input type='text' class='form-control' placeholder='Unesite jedinicu mere...' name='invoiceRecordList[" + (counter - 1) + "].unitOfIssue'/></div>";
    stavka += "<div class='form-group'><label>Jedinicna cena</label><input type='text' class='form-control' placeholder='Unesite cenu...' name='invoiceRecordList[" + (counter - 1) + "].unitPrice'/></div>";
    stavka += "<div class='form-group'><label>Vrednost</label><input type='text' class='form-control' placeholder='Unesite vrednost...' name='invoiceRecordList[" + (counter - 1) + "].value'/></div>";
    stavka += "<div class='form-group'><label>Procenat rabata</label><input type='text' class='form-control' placeholder='Unesite procenat rabata...' name='invoiceRecordList[" + (counter - 1) + "].rebatePercentage'/></div>";
    stavka += "<div class='form-group'><label>Iznos rabata</label><input type='text' class='form-control' placeholder='Unesite iznos rabata...' name='invoiceRecordList[" + (counter - 1) + "].rebateAmount'/></div>";
    stavka += "<div class='form-group'><label>Umanjeno za rabat</label><input type='text' class='form-control' placeholder='Unesite umanjenje...' name='invoiceRecordList[" + (counter - 1) + "].rebateDeducted'/></div>";
    stavka += "<div class='form-group'><label>Ukupan porez</label><input type='text' class='form-control' placeholder='Unesite ukupan porez...' name='invoiceRecordList[" + (counter - 1) + "].taxTotal'/></div>";
    stavka += "<div class='form-group'><input type='hidden' name='invoiceRecordList[" + (counter - 1) + "].recordNumber' value='" + counter + "'/></div>";
    
    var html = "<div class='row'><div class='col-md-12'><div class='panel panel-default'><div class='panel-body'>"+stavka+"</div></div></div></div>";
    
    return html;
}