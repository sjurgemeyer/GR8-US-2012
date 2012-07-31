// presenter js
var w = null;

$(function(){
	w = window.open('/');
  // side menu accordian crap
	$("#preso").bind("showoff:loaded", function (event) {
		$(".menu > ul ul").hide()
		$(".menu > ul a").click(function() {
			if ($(this).next().is('ul')) {
				$(this).next().toggle()
			} else {
				gotoSlide($(this).attr('rel'))
				w.gotoSlide($(this).attr('rel'))
				postSlide()
			}
			return false
		}).next().hide()
	})
});

function presPrevStep()
{
	prevStep()
	w.prevStep()
	postSlide()
}

function presNextStep()
{
	nextStep()
	w.nextStep()
	postSlide()
}

function postSlide()
{
	if(currentSlide) {
		var notes = w.getCurrentNotes()
		var fileName = currentSlide.children().first().attr('ref')
		$('#notes').text(notes)
		$('#slideFile').text(fileName)
	}
}

//  See e.g. http://www.quirksmode.org/js/keys.html for keycodes
function keyDown(event)
{
	var key = event.keyCode;

	if (event.ctrlKey || event.altKey || event.metaKey)
		return true;

	debug('keyDown: ' + key)

	if (key >= 48 && key <= 57) // 0 - 9
	{
		gotoSlidenum = gotoSlidenum * 10 + (key - 48);
		return true;
	}

	if (key == 13) {
		if (gotoSlidenum > 0) {
			debug('go to ' + gotoSlidenum);
			slidenum = gotoSlidenum - 1;
			showSlide(true);
			w.slidenum = gotoSlidenum - 1;
			w.showSlide(true);
			gotoSlidenum = 0;
		} else {
			debug('executeCode');
			executeAnyCode();
			w.executeAnyCode();
		}
	}

	if (key == 16) // shift key
	{
		shiftKeyActive = true;
	}

	if (key == 32) // space bar
	{
		if (shiftKeyActive) {
			presPrevStep()
		} else {
			presNextStep()
		}
	}
	else if (key == 68) // 'd' for debug
	{
		debugMode = !debugMode
		doDebugStuff()
	}
	else if (key == 37 || key == 33 || key == 38) // Left arrow, page up, or up arrow
	{
		presPrevStep()
	}
	else if (key == 39 || key == 34 || key == 40) // Right arrow, page down, or down arrow
	{
		presNextStep()
	}
	else if (key == 84 || key == 67)  // T or C for table of contents
	{
		$('#navmenu').toggle().trigger('click')
	}
	else if (key == 90 || key == 191) // z or ? for help
	{
		$('#help').toggle()
	}
	else if (key == 66 || key == 70) // f for footer (also "b" which is what kensington remote "stop" button sends
	{
		toggleFooter()
	}
	else if (key == 78) // 'n' for notes
	{
		toggleNotes()
	}
	else if (key == 27) // esc
	{
		removeResults();
		w.removeResults();
	}
	else if (key == 80) // 'p' for preshow
	{
		w.togglePreShow();
	}
	return true
}
