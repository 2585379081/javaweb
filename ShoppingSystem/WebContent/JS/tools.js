
//自定义弹框
function Toast(msg,duration){
    duration=isNaN(duration)?3000:duration;
    var m = document.createElement('div');
    m.innerHTML = msg;
    m.style.cssText="width: 170px;min-width: 150px;opacity: 0.7;" +
        "height: 50px;color: rgb(255, 255, 255);" +
        "line-height: 50px;text-align: center;border-radius: 5px;" +
        "position: fixed; margin:auto;top: 20%;left: 0px;right: 0px;" +
        "z-index: 999999;background: rgb(0, 0, 0);font-size: 12px;";
    document.body.appendChild(m);
    setTimeout(function() {
        var d = 0.5;
        m.style.webkitTransition = '-webkit-transform ' + d + 's ease-in, opacity ' + d + 's ease-in';
        m.style.opacity = '0';
        setTimeout(function() { document.body.removeChild(m) }, d * 1000);
    }, duration);
}
