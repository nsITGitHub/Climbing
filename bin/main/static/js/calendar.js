const weeks = ['日', '月', '火', '水', '木', '金', '土']
const date = new Date()
let year = date.getFullYear()
let month = date.getMonth() + 1
let climsList = document.querySelectorAll('.climsList')
let newsList = document.querySelectorAll('.newsList')

/*const config = {
    show: 1,
}*/

  function showCalendar(year, month) {
    
        const calendarHtml = createCalendar(year, month)
  
        const sec = document.createElement('section')
        sec.innerHTML = calendarHtml
        document.querySelector('#calendar').appendChild(sec)
        }


  function createCalendar(year, month) {
	
    const startDate = new Date(year, month - 1, 1) // 月の最初の日を取得
    const endDate = new Date(year, month,  0) // 月の最後の日を取得
    const endDayCount = endDate.getDate() // 月の末日
    const lastMonthEndDate = new Date(year, month - 1, 0) // 前月の最後の日の情報
    const lastMonthendDayCount = lastMonthEndDate.getDate() // 前月の末日
    const startDay = startDate.getDay() // 月の最初の日の曜日を取得
    let dayCount = 1 // 日にちのカウント
    let calendarHtml = '' // HTMLを組み立てる変数

    calendarHtml += '<div class="calendaryear">' + year  + '年' + month + '月' + '</div>'
    calendarHtml += '<div class="bodycalendar"><table class="t-calender">'

    // 曜日の行を作成
    for (let i = 0; i < weeks.length; i++) {
        calendarHtml += '<td>' + weeks[i] + '</td>'
    }

    for (let w = 0; w < 6; w++) {
        calendarHtml += '<tr>'

        for (let d = 0; d < 7; d++) {
            if (w == 0 && d < startDay) {
                // 1行目で1日の曜日の前
                let num = lastMonthendDayCount - startDay + d + 1
                calendarHtml += '<td class="is-disabled">' + num + '</td>'
            } else if (dayCount > endDayCount) {
                // 末尾の日数を超えた
                let num = dayCount - endDayCount
                calendarHtml += '<td class="is-disabled">' + num + '</td>'
                dayCount++
            } else {
                calendarHtml += `<td class="calendar_td" data-date="${year}/${month}/${dayCount}">${dayCount}`
        
             	
  				climsList.forEach(e =>{
					let bolText = e.querySelector('.bolText').textContent
					let bolMonth = e.querySelector('.bolMonth').textContent
					let bolDate = e.querySelector('.bolDate').textContent
					let bolYear = e.querySelector('.bolYear').textContent
			
					
					if (bolYear == year && bolMonth == month && bolDate == dayCount) {
      				calendarHtml +=`<p class="calendartext">${bolText}</p>`
    				}
  				})
  				
  				newsList.forEach(e =>{
					let bolnews = e.querySelector('.newscontents').textContent
					let bolMonth = e.querySelector('.newsMonth').textContent
					let bolDate = e.querySelector('.newsDate').textContent
					let bolYear = e.querySelector('.newsYear').textContent
					let bolLink = e.querySelector('.link').textContent
					
					if (bolYear == year && bolMonth == month && bolDate == dayCount) {
      				calendarHtml +=`<p class="calendarevent"><a class="calenderlink" href="${bolLink}}" target="_blank">${bolnews.substring(0,20)}</a></p>`
					}
				})
  				
                                
                	/*events.forEach(event => {
    				if (event.date.getFullYear() === year && event.date.getMonth() === month && event.date.getDate()=== dayCount) {
      				calendarHtml +=`<div>${event.title}</div>`
    				}
  					});
  					events.date.getFullYear() === year 
  					*/
  					
                calendarHtml += '</td>'
                dayCount++
            }
        }
       
        calendarHtml += '</tr>'
    }
    calendarHtml += '</table></div>'
    return calendarHtml

}





function moveCalendar(e) {
    document.querySelector('#calendar').innerHTML = ''

    if (e.target.id === 'prev') {
        month--

        if (month < 1) {
            year--
            month = 12
        }
    }

    if (e.target.id === 'next') {
        month++

        if (month > 12) {
            year++
            month = 1
        }
    }

    showCalendar(year, month)
}



document.querySelector('#prev').addEventListener('click', moveCalendar)
document.querySelector('#next').addEventListener('click', moveCalendar)

showCalendar(year, month)


/*document.addEventListener("click", function(e) {
    if(e.target.classList.contains("calendar_td")) {
        alert('クリックした日付は' + e.target.dataset.date + 'です')
    }
})*/

  /*
var target = documet.getElementById("newsList")
target.scrollIntoView("false")
*/
  

