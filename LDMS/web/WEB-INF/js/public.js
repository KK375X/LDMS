/**
 * 公共的JavaScript方法
 * @returns {string}
 */

// 获取当前时间
function nowTime() {//获取当前时间
    let now = new Date();
    let _month = (10 > (now.getMonth() + 1)) ? '0' + (now.getMonth() + 1) : now.getMonth() + 1;
    let _day = (10 > now.getDate()) ? '0' + now.getDate() : now.getDate();
    let _hour = (10 > now.getHours()) ? '0' + now.getHours() : now.getHours();
    let _minute = (10 > now.getMinutes()) ? '0' + now.getMinutes() : now.getMinutes();
    let _second = (10 > now.getSeconds()) ? '0' + now.getSeconds() : now.getSeconds();
    return now.getFullYear() + '-' + _month + '-' + _day + ' ' + _hour + ':' + _minute + ':' + _second;
}

// 重置文本框
function reset() {
    $('#id').val('');
    $('#name').val('');
    $('#password').val('');
    $('#password_again').val('');
    $('#phone').val('');
    $('#studentId').val('');
    $('#age').val('');
    $('#sex').val('');
    $('#teacherId').val('');
    $('#classes').val('');
    $('#college').val('');
    $('#position').val('');
    $('#laboratoryId').val('');
    $('#laboratoryName').val('');
    $('#address').val('');
    $('#deviceId').val('');
    $('#type').val('');
    $('#deviceName').val('');
    $('#state').val('');
    $('#userId').val('');
    $('#useDate').val('');
    $('#beginTime').val('');
    $('#endTime').val('');
    $('#again_password').val('');
}

