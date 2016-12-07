var Comprobaciones = function(){

    this.comprobarSolape = function(profesor,A0,Af){
       puede = true;
		if(profesor.getClases().hasOwnProperty(A0)||profesor.getClases().hasOwnProperty(Af)){
			puede = false;
		}else{
			partes0 = A0.split(":");
			partesf = Af.split(":");
			horas = Object.keys(profesor.getClases());
			horas.forEach(function(element){
				ps = element.split(":");
				if(p[0]>partes0[0]&&p[0]<partesf[0]){
					puede = false;
					break;
				}
			});
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