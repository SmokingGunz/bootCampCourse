var usernameTextBox = document.querySelector(`#username`);

usernameTextBox.addEventListener('blur', () => {
    var user = {
        'username': usernameTextBox.value,
    }
    fetch('/user/exists', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then((response) => response.json())
        .then((data) => {
            if (data === true) {
                console.log('username already exists')
                usernameTextBox.focus()
                usernameTextBox.select()
                showErrorAnimation(() => {
                    // animation is completed at this point
                    console.log("we are now in the callback function")

                    usernameTextBox.style.backgroundColor = `rgb(255, 255, 255)`;
                })
            }
        })
});

function showErrorAnimation(callback) {
    console.log("We're in the showErrorAnimation function");

    var i = 255;

    var animationInterval = setInterval(() => {
        i--;

        // Decrease the green and blue components from 255 to 0
        usernameTextBox.style.backgroundColor = `rgb(255, ${i}, ${i})`;

        if (i === 0) {
            clearInterval(animationInterval);
            callback();
        }
    }, 1);

    console.log("Done executing the showErrorAnimation function");
}