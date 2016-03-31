"use strict";

var React = require('react');

var Rules = React.createClass({
	render: function() {
		return(
<div>
<div className="list-group col-md-8 col-md-offset-2">
    <h4 className="list-group-item-heading">Sistem takmicenja</h4>
</div>
<div className="list-group col-md-8 col-md-offset-2"> 
   <h4 className="list-group-item-heading">Opsta pravila</h4>
   <ol >
	<li>Rangiranje se vrsi na sledeci nacin</li>
	<ul id="listaPravilaRangiranja">
	  <li>- broj bodova</li>
	  <li>- gol razlika</li>
	  <li>- broj datih golova</li>
	  <li>- medjusobni skor</li>
	 </ul>
	<li>Utakmice se igraju od petka do srede, termin dogovaraju ekipe posebno.</li>
	<li>Ako ekipe imaju problem da se dogovore oko termina, domacin daje gostu 3 razlicita termina od kojih gost mora izabrati jedan.</li>
	<li>Krivica za neodigravanje neke utakmice je poraz od 5:0 u ligaskom delu, dok je u nokaut fazi kazna izbacivanje te ekipe, pri cemu ekipa koja nije krivac treba da dostavi bilo kakav dokaz da je druga ekipa odbila da igra.</li>
	<li>Domaca ekipa zadrzava pravo da odluci da li se igra 4+1 ili 5+1 (ili nesto trece).</li>
	<li>Pobeda donosi 3 boda, poraz 0, neresen rezultat po 1 bod. </li></ol>
</div>
<div className="list-group col-md-6 col-md-offset-3">
 <h4 className="list-group-item-heading">Ostalo</h4>
<p>
Organizator moze dodati ili promeniti neko pravilo ako se za tim ukaze potreba u toku Lige, ako je neophodno.
</p>
</div>
</div>	
);
	}
});


module.exports = Rules;