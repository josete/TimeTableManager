var Comprobaciones = function(){

    this.comprobarSolape = function(profesor,hora){
       tiene = false;
		if(profesor.getClases().hasOwnProperty(hora)){
			tiene = true;
		}
		return tiene;
    }
}

module.exports = Comprobaciones;