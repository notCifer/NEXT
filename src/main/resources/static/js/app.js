const navSlide = () =>{
    const burger = document.querySelector('.burger');
    const nav = document.querySelector('.list');

    burger.addEventListener('click',()=>{
        nav.classList.toggle('list-active');

    });
}
navSlide();