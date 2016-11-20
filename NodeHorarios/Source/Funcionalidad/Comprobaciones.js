var Comprobaciones = function(){

    this.comprobarSolape = function(profesor,hora){
       puede = true;
		if(profesor.getClases().hasOwnProperty(hora)){
			puede = false;
		}
		return puede;
    }

	this.comprobarHorasDiarias = function(profesor,sesion,dia){
		puede = true;
		if(profesor.horasDias[dia]==undefined || profesor.maxHorasDia==undefined){
			return true;
		}else{
			if(profesor.horasDias[dia]<profesor.maxHorasDia){
				if(profesor.horasDias[dia]+sesion.getHoras()>profesor.maxHorasDia){
					puede = false;
				}
			}else{
				puede = false;
			}
		}
		return puede;
	}
}

module.exports = Comprobaciones;