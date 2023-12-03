$(document).ready(function () {
    $('#calendar').fullCalendar({
        defaultView: 'month',
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,basicWeek,basicDay'
        },
        events: [],
        dayClick: function (date) {
            let dataLembrete = date.format('D/MM/YYYY');
            let dt = new Date(date);

            $('#modalLembrete').modal('show');
            $('#reminderDate').val(dataLembrete);
            $('#dayId').val(dt.getDate());
            $('#monthId').val(dt.getMonth());
            $('#year').val(dt.getTime());

        }
    });


    function exibirLembrete() {
        var dataLembrete = $('#reminderDate').val();
        var assuntoLembrete = $('#reminderText').val();
        var dataLembreteFormatada = moment(dataLembrete, 'D/MM/YYYY').toISOString();

        $('#calendar').fullCalendar('renderEvent', {
            title: assuntoLembrete,
            start: dataLembreteFormatada,
            allDay: true
        });

        console.log("Lembrete adicionado com sucesso");
        limparModal();
    }

    function limparModal(){
        $('#reminderDate').val("");
        $('#reminderText').val("");
        $('#reminderTime').val("");
        $('#dayId').val("");
        $('#monthId').val("");
        $('#year').val("");
        $('#modalLembrete').modal('hide');
    }

    $('#btnSalvar').click(function () {
        exibirLembrete();
    });

    $('#btnFechar').click(function () {
        limparModal();
    });

});
