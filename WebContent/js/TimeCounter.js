var Timer;
var TotalSeconds;
var callback;

function CreateTimer(TimerID, Time, callbackfunction) {
    Timer = document.getElementById(TimerID);
    TotalSeconds = Time;
    callback = callbackfunction;
    
    UpdateTimer();
    window.setTimeout("Tick()", 1000);
}

function Tick() {
    TotalSeconds -= 1;
    
    if(TotalSeconds>=0)
    {
    	UpdateTimer();
		window.setTimeout("Tick()", 1000);
    }
    else
    {
    	callback();
    }
}

function UpdateTimer() {
    var Seconds = TotalSeconds;
    
    var Days = Math.floor(Seconds / 86400);
    Seconds -= Days * 86400;

    var Hours = Math.floor(Seconds / 3600);
    Seconds -= Hours * (3600);

    var Minutes = Math.floor(Seconds / 60);
    Seconds -= Minutes * (60);
    
    //var TimeStr = "<b>Please wait while redirecting to bank page in ... " +((Days > 0) ? Days + " days " : "") + LeadingZero(Hours) + ":" + LeadingZero(Minutes) + ":" + LeadingZero(Seconds)+"<b>";
    //var TimeStr = LeadingZero(Seconds);
    var TimeStr = "<b>Please wait while redirecting to bank page in ... " + LeadingZero(Seconds)+"<b>";
    Timer.innerHTML = TimeStr;
}

function LeadingZero(Time) {
    return (Time < 10) ? "0" + Time : + Time;
}