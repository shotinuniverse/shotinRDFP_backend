package backend.common

import java.time.LocalDateTime

class WorkingWithDate {

    // "0001-01-01 00:00:00"
    fun getLocalDateFromSQLDate(sqlDate: String): LocalDateTime{

        var arraySpace = sqlDate.split(" ")
        var finishDate: LocalDateTime = LocalDateTime.now()

        if (arraySpace.size == 2){
            var arrayYearMonthDay = arraySpace[0].split("-")
            var arrayHourMinuteSecond = arraySpace[1].split(":")

            if(arrayYearMonthDay.size == 3 && arrayHourMinuteSecond.size == 3)
                finishDate = LocalDateTime.of(
                    arrayYearMonthDay[0].toInt(),
                    arrayYearMonthDay[1].toInt(),
                    arrayYearMonthDay[2].toInt(),
                    arrayHourMinuteSecond[0].toInt(),
                    arrayHourMinuteSecond[1].toInt(),
                    arrayHourMinuteSecond[2].toInt())

        }

        return finishDate
    }
}