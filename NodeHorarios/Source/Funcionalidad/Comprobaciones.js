var Comprobaciones = function(){

    this.comprobarSolape = function(profesor,A0,Af){
       puede = 10;
       if(Object.keys(profesor.getClases()).length>0){
		if(profesor.getClases().hasOwnProperty(A0)||profesor.getClases().hasOwnProperty(Af)){
			puede = 0;
		}else{
			partes0 = A0.split("-");
			partesf = Af.split("-");
			horas = Object.keys(profesor.getClases());
			horas.forEach(function(element){
				ps = element.split("-");
				if(p[1]>partes0[0]&&p[1]<partesf[1]){
					puede = 0;
				}
			});
		}
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