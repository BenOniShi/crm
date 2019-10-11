$(function () {
    loadCustomerFX();
})
function loadCustomerFX() {
    $.ajax({
        type:'post',
        url:ctx+"/customer/countLevelByCustomer",
        datatype:'json',
        success:function (data) {
            console.log(data)

            var myChart = echarts.init(document.getElementById('main'));

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '客户分析'
                },
                tooltip: {},
                legend: {
                    data:['客户构成分析']
                },
                xAxis: {
                    data: data.result1
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: data.result2
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    })
}