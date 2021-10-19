function func1(x) {
    var result = x + 10;
    return result;
}

function func2(x) {
    var f2 = function() {
        return 10;
    }
    var result = x + f2();
    return result;
}

function func3(x) {
    var y = function() {
        return 10;
    }();
    var result = x + y;
    return result;
}

function func4(x, y) {
    console.log("x: " + x);
    console.log("y: " + y);
    console.log("arguments: ");
    for(var v of arguments) {
        console.log("\t\t\t" + v);
    }
}

function func5(x) {
    return x();
}
function func6() {
    return 10;
} 