$(function () {
    $('#diaryDate').val(new Date().toISOString().substring(0,10));
    var dateValue = $('#diaryDate').val();

    var diary = {
        regDate : dateValue
    }

    info(diary);

    $('#diaryDate').on('change', function () {
        diary={
            regDate: $('#diaryDate').val()
        }
        info(diary)
    });

    function info(diary) {
        $.ajax({
            url: '/diary/info',
            type: 'post',
            data:diary,
            success: function (data) {
                $('#info').replaceWith(data);
            }
        })
    }



    var total = 0;
    for(var i = 0; i<document.getElementsByClassName("sub1").length; i++){
      var ResultToInt = parseInt(document.getElementsByClassName("sub1")[i].innerText);
        alert(ResultToInt);
      total = total + ResultToInt;
    }
    alert(parseInt(document.getElementById("sub1Result").innerText));
    alert(parseInt(document.getElementsByClassName("sub1")[1].innerHTML));
    document.getElementById("sub1Result").innerText = total;
    console.log(document.getElementById("sub1Result").innerText);

});