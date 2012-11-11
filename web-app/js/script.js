$(document).ready(function() {
    $('.flipper').click(function() {
        $(this).hide();
        $('.chooser').show();
        var flashcard = $(this).parent().siblings(':first');
        var answer = flashcard.children(':nth-child(2)').html();
        flashcard.flippy({
            onStart: function() {
                flashcard.addClass('no-chrome');
            },
            onFinish: function() {
                flashcard.removeClass('no-chrome');
            },
            duration: 600,
            direction: 'LEFT',
            content: '<p>'+answer+'</p>',
        });
    });
});
