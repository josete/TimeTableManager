var Comprobaciones = function(){

    this.comprobarSolape = function(profesor,hora){
       puede = true;
		if(profesor.getClases().hasOwnProperty(hora)){
			puede = false;
		}
		return puede;
    }

	this.comprobarHorasDiarias = function(profesor,sesion){
		puede = true;
		if(profesor.maxHorasDia==undefined){
			return true;
		}else{
			if(profesor.horasDiaActual<profesor.maxHorasDia){
				if(profesor.horasDiaActual+sesion.getHoras()>profesor.maxHorasDia){
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