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
    stavka += "<div class='form-group'><label>Naziv robe ili usluge</label><input type='text' class='form-control' placeholder='Unesite naziv...'/></div>";
    stavka += "<div class='form-group'><label>Kolicina</label><input type='number' class='form-control' placeholder='Unesite kolicinu...'/></div>";
    stavka += "<div class='form-group'><label>Jedinica mere</label><input type='text' class='form-control' placeholder='Unesite jedinicu mere...'/></div>";
    stavka += "<div class='form-group'><label>Jedinicna cena</label><input type='number' class='form-control' placeholder='Unesite cenu...'/></div>";
    stavka += "<div class='form-group'><label>Vrednost</label><input type='number' class='form-control' placeholder='Unesite vrednost...'/></div>";
    stavka += "<div class='form-group'><label>Procenat rabata</label><input type='number' class='form-control' placeholder='Unesite procenat rabata...'/></div>";
    stavka += "<div class='form-group'><label>Iznos rabata</label><input type='number' class='form-control' placeholder='Unesite iznos rabata...'/></div>";
    stavka += "<div class='form-group'><label>Umanjeno za rabat</label><input type='number' class='form-control' placeholder='Unesite umanjenje...'/></div>";
    stavka += "<div class='form-group'><label>Ukupan porez</label><input type='number' class='form-control' placeholder='Unesite ukupan porez...'/></div>";
    
    var html = "<div class='row'><div class='col-md-12'><div class='panel panel-default'><div class='panel-body'>"+stavka+"</div></div></div></div>";
    
    return html;
}