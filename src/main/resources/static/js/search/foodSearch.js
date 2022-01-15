$(function() {
    $('#searchFood').autocomplete({ // autocomplete 구현 시작부
        source : function(request, response){
            $.ajax({
                type : 'get',
                url :'/foodApi/search',
                dataType: "json",
                data:{searchVal: request.term},
                success:function (data){
                    const dataList = data.I2790.row
                    console.log(dataList)
                    response(
                        $.map(dataList, function (item) {
                            return{
                                label: item.DESC_KOR,
                                value: item.DESC_KOR,
                                test : item.FOOD_CD
                            }
                        })
                    );
                }
            })
        }, //source 는 자동완성의 대상
        select : function(event, ui) { // item 선택 시 이벤트
            console.log(ui);
            console.log(ui.item.test)
            $('#food_cd').val(String(ui.item.test));
        },
        focus : function(event, ui) { // 포커스 시 이벤트
            return false;
        },
        minLength : 1, // 최소 글자 수
        autoFocus : true, // true로 설정 시 메뉴가 표시 될 때, 첫 번째 항목에 자동으로 초점이 맞춰짐
        classes : { // 위젯 요소에 추가 할 클래스를 지정
            'ui-autocomplete' : 'highlight'
        },
        delay : 500, // 입력창에 글자가 써지고 나서 autocomplete 이벤트 발생될 떄 까지 지연 시간(ms)
        disable : false, // 해당 값 true 시, 자동완성 기능 꺼짐
        position : { my : 'right top', at : 'right bottom',scroll}, // 제안 메뉴의 위치를 식별
        close : function(event) { // 자동완성 창 닫아질 때의 이벤트
            console.log(event);
        }
    });

    $('#searchBtn').on("click",function(){
        const foodname = $("#searchFood").val();
        const foodcd = $('#food_cd').val();

        console.log("foodname : " + foodname)
        console.log("foodcd : " + foodcd);
        fetch("/foodApi/search",{
            method: 'post',
            body: String(foodcd),
            headers:{
                'Content-Type':'application/json'
            }
        })
            .then(data=>data.json())
            .then(data=>{
                console.log("111111111111")
                console.log(data.I2790.row[0])
                var dataResult = data.I2790.row[0]
                fetch('/food/searchResult',{
                    method: 'post',
                    body:JSON.stringify({dataResult}),
                    headers:{
                        'Content-Type':'application/json'
                    }
                }).then(function(response){
                    response.text().then(function(text){
                        $('.noSearch').empty();
                        $('.noSearch').remove();
                        document.getElementById("searchResult").innerHTML = text;
                        console.log("화면 안됐는데 뜨면안됨")
                    })
                })
            })
            .catch((error)=>console.log('error입니다.'))
    })
});