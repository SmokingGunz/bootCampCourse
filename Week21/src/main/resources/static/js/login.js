var submitBtn = document.querySelector('#submitBtn') // this selects the button by id and assigns it to a variable
// console.log(`submitBtn is : `)
// console.log(submitBtn)
var users = []

submitBtn.addEventListener('click', (event) => {
    var username = document.querySelector('#username')
    var password = document.querySelector('#password')

    if (username.value == '' || password.value == '') {
        alert('Please enter your username and password')
    } else {
        console.log('Inputs look valid, proceed with submission')
        var user = {
            username: username.value,
            password: password.value

        }

        users.push(user)
    }
})

username.addEventListener('blur', () => {
    var username = document.querySelector('#username')
    var password = document.querySelector('#password')

    var user = {
        "username": username.value,
        "password": password.value
    }


    //This is how to fetch with PostMapping
    fetch(`/user/exists`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then((response) => response.json())
        .then((data) => {
            console.log(data)
        })

    // this is how to fetch with GetMapping
    // fetch(`http://localhost:8080/user/exists?username=${username.value}&password=${password.value}`)
    //     .then((response) => response.json())
    //     .then((data) => {
    //         console.log(data)
    //     })
})


// submitBtn.addEventListener('mouseover', function () {
//     alert(`Hey! I've been moused over!`)

// })

// var usernameTextBox = document.querySelector('#username') // this selects the username

// // different way to add an event listener function with lambda function
// usernameTextBox.addEventListener('focus', () => console.log(`The username Text Box now has focus!`)
// )

// // public void myFunction() {}  -- this is java code for comparison purposes
// function submitBtnClick() {
//     alert("Hey! I've been clicked")

// }