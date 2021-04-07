;(window.onload = () => {
  let btnDom = document.querySelector(".goto-btn")
  btnDom.style.display = "none"
  let timer = null
  if (btnDom) {
    btnDom.addEventListener("click", () => {
      if (!timer) {
        timer = setInterval(() => {
          window.scrollBy(0, -50) //相对于原来位置滚动 scrollto相对于屏幕位置滚动
          let scrollTop = document.documentElement.scrollTop || document.body.scrollTop
          if (scrollTop === 0) {
            clearInterval(timer)
            timer = null
          }
        }, 10)
      }
    })
  }
  //监听滚动条
  window.onscroll = () => {
    //为了保证兼容性，这里取两个值，哪个有值取哪一个
    //scrollTop就是触发滚轮事件时滚轮的高度
    let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
    btnDom.style.display = scrollTop >= 400 ? "block" : "none"
  }
})()