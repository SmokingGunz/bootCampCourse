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
        } else { }
    })
});