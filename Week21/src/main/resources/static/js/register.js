var usernameTextBox = document.querySelector(`#username`);
var eyeIcons = document.querySelectorAll(`.fa-eye`);

eyeIcons.forEach((eyeIcon) => {
    eyeIcon.addEventListener('click', () => {
        if (eyeIcon.classList.contains('fa-eye')) {
            eyeIcon.classList.replace('fa-eye', 'fa-eye-slash');
            if (eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
                document.querySelector(`#password`).type = 'text';
            } else {
                document.querySelector(`#confirmPassword`).type = 'text';
            };
        } else {
            eyeIcon.classList.replace('fa-eye-slash', 'fa-eye');
            if (eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
                document.querySelector(`#password`).type = 'password';
            } else {
                document.querySelector(`#confirmPassword`).type = 'password';
            };
        };
    });
});

// HOW TO USE PROMISES IN JS

usernameTextBox.addEventListener('blur', () => {
    var user = {
        'username': usernameTextBox.value,
    }
// call async function
    asyncCheckIfUserExists(user);
});

async function asyncCheckIfUserExists(user) {
    let something = await checkIfUserExists(user);
        console.log('check code here');
    }

   async function checkIfUserExists(user) {
        let response = await fetch('/user/exists', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
        let data = await response.json()
        // .then((response) => response.json())
        // .then((data) => {
            if (data === true) {
                console.log('username already exists');
                usernameTextBox.focus();
                usernameTextBox.select();
                return showErrorAnimation()
                .then((message) => {
                    console.log("we are now in the Promise's then method after the animation");
                    console.log(message);
                    usernameTextBox.style.backgroundColor = `rgb(255, 255, 255)`;
                });
            }
        }
    
    function showErrorAnimation() {
        return new Promise((resolve) => {
            console.log("We're in the showErrorAnimation function");
            
            var i = 255;
            
            var animationInterval = setInterval(() => {
                i--;
                
                // Decrease the green and blue components from 255 to 0
                usernameTextBox.style.backgroundColor = `rgb(255, ${i}, ${i})`;
                
                if (i === 0) {
                    clearInterval(animationInterval);
                    // console.log("Done executing the showErrorAnimation function");
                    resolve("Done executing the showErrorAnimation function");
                }
            }, 1);
        });
    }
    
    // this is for demonstration purposes only
    // function myPromise() {
    
    //     return new Promise((resolve, reject) => {
    //         let i = 2;
    
    //         if (i === 1) {
    //             resolve("hey, i === 1, so we're cool");
    //         } else {
    //             reject("Absolute fail: i is not 1, boooo");
    //         }
    
    //     })
    // }
    
    // myPromise().then((data) => {
    //     console.log(data);
    // }).catch((error) => {
    //     console.log("Absolute fail: i is not 1, boooo");
    // });
    
    // HOW TO USE CALLBACK FUNCTION IN JS
    
// usernameTextBox.addEventListener('blur', () => {
//     var user = {
//         'username': usernameTextBox.value,
//     }
//     fetch('/user/exists', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(user)
//     })
//         .then((response) => response.json())
//         .then((data) => {
//             if (data === true) {
//                 console.log('username already exists')
//                 usernameTextBox.focus()
//                 usernameTextBox.select()
//                 showErrorAnimation(() => {
//                     // animation is completed at this point
//                     console.log("we are now in the callback function")

//                     usernameTextBox.style.backgroundColor = `rgb(255, 255, 255)`;
//                 })
//             }
//         })
// });

// function showErrorAnimation(callback) {
//     console.log("We're in the showErrorAnimation function");

//     var i = 255;

//     var animationInterval = setInterval(() => {
//         i--;

//         // Decrease the green and blue components from 255 to 0
//         usernameTextBox.style.backgroundColor = `rgb(255, ${i}, ${i})`;

//         if (i === 0) {
//             clearInterval(animationInterval);
//             callback();
//         }
//     }, 1);

//     console.log("Done executing the showErrorAnimation function");
// }