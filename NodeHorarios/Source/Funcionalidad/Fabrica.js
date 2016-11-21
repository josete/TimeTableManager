profesor = require("../Objetos/Profesor.js");

var fabrica = function(){

    this.fabricar = function(tipo,datos){
        objeto = null;
        switch(tipo){
            case "Profesor":
                objeto = new profesor(datos.nombre,datos.min,datos.max);
                break;
        }
        return objeto;
    }
}

module.exports = fabrica;