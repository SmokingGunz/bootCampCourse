var submitBtn = document.querySelector('#submitBtn') // this selects the button by id and assigns it to a variable
// console.log(`submitBtn is : `)
// console.log(submitBtn)
var username = document.querySelector('#username')
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

    fetch('http://localhost:8080/user/exists')
        .then((response) => {
            console.log(response)
        })
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