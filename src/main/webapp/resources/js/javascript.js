/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivan
 */

$(document).ready(function () {
    var $filas = ($("[id='recetasPacienteForm:recetas'] tbody tr")).length;

    for (var i = 0, max = $filas; i < max; i++) {
        var $estadoReceta = $("[id='recetasPacienteForm:recetas:" + i + ":estadoReceta']").text();
        var $situacion = $("[id='recetasPacienteForm:recetas:" + i + ":situacionReceta']").text();

        if (($situacion === "no disponible") || ($estadoReceta === "SERVIDA")) {
            $("[id='recetasPacienteForm:recetas:" + i + ":servirReceta']").attr("class", "btn disabled");
        } else {
            $("[id='recetasPacienteForm:recetas:" + i + ":servirReceta']").attr("class", "btn btn-primary");
        }
    }

    //VISTA MÉDICO

    var $hoy = new Date();
    $("[id='fecha_citas_hoy']").html("Agenda para el: " + $hoy.getDate() + "/" + ($hoy.getMonth() + 1) + "/" + $hoy.getFullYear());
    var $filas = ($("[id='searchForm:lista_citas'] tbody tr")).length;
    for (var i = 0, max = $filas; i < max; i++) {
        var $estadoCita = $("[id='searchForm:lista_citas:" + i + ":estadoCita']").text();
        if ($estadoCita !== "PLANIFICADA") {
            $("[id='searchForm:lista_citas:" + i + ":atender-button']").attr("class", "btn disabled");
        }
    }


});
