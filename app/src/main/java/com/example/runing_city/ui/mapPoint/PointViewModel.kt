package com.example.runing_city.ui.mapPoint


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PointViewModel : ViewModel() {

    private val _listOfPoints = MutableLiveData<List<MapPoint>>().apply {
        value = samplePoints
    }
    val listOfPoints:  List<MapPoint> = _listOfPoints.value!!
    private val _passedPoints = MutableLiveData<Int>()
    val passedPoints: LiveData<Int>
        get() = _passedPoints

    init {
        _passedPoints.value = 0
    }
    fun onCorrect() {
        _passedPoints.value = (_passedPoints.value)?.plus(1)
    }
    fun getPoint(index: Int): MapPoint{
        return listOfPoints[index]
    }


}

data class MapPoint(val pointId: Int,val title: String, val lat: Double, val lng: Double, val description: String, val details: String, val answer: String, var passed: Boolean = false)

val samplePoints = listOf(
    MapPoint(0,"Vörösmarty tér metro station", 47.496676, 19.050398,
        "Copy the door numbers in descending order",
        "While traveling on the M1 line, the oldest in Budapest, you can imagine yourself in the past. Almost everything here remained untouched. Well, they changes the railing and some other staff in carriages. The line is as straight as an arrow and on the final stops (like here) you can even see the train making a U turn. By the way there is another typical \"runcity point\" nearby. The Retro Transformer Kiosk stands right near the entrance to the undergound station and with some luck you'll find it in the middle of all this Christmas hype on the square.",
        "321"),
    MapPoint(1,"Király utca, 15", 47.499344, 19.058711,
        "Plaque with tenants’ names\n" +
            "Copy the name of the tenant from flat No. 21",
        "Look though the square peephole in the door. The stone wall in the end of the courtyard is the memorial Ghetto Wall. The Budapest ghetto was created on November 29, 1944, and soon it was surrounded by a high stone wall. The last remaining section of the ghetto wall was demolished here in 2006 but two years later it was restored as а memorial.",
        "csukai józsef"),
    MapPoint(2,"Papp László tér", 47.524406, 19.067518,
        "Monument to an athlete.\n" +
            "Maximum year of those mentioned on the monument.",
        "Papp Laslo was once a downtown boy who used his fists only in backyard boxing championships." +
            " But after WWII Papp started as a trainee on the Optical Instruments Plant, where was an amateur boxing group. There strated his glorious path to the Olympics. " +
            "Papp was an Olympic gold medalist three times, at middleweight in London in 1948, then as a light middleweight in Helsinki in 1952 and in Melbourne in 1956." +
            " Papp also was the European middleweight champion as a middleweight in 1949 at Oslo and at light middleweight at Milan 1951. He scored 55 first round knockouts as an amateur. " +
            "His only dream was to win the World Championship as a professional boxer. " +
            "But the dream stayed unaccomplished, the Communists didn't let him to fight as a professional for the Hungary on the championships.\n", "2016"),
    MapPoint(3,"The Eastern Railroad Station (Keleti palyaudvar)", 47.489458, 19.063919,
        "Green second-hand book cart on the square",
        "A fashionable building near to a green cart with second-hand books is the Erwin Sabo Central Library (Szabó Ervin tér 1). Once upon a time it was the well-known and loved by all the Budapest’s high society palace of the Wenkhein family. The marriage of Christina and Fridesh Wenkheim was scandalous. They were cousins and truly in love with each other, but all their relatives were against this misalliance. Christina was the heiress of a huge fortune and raised like a princess, but for everyone she was only a сhild of sin. Her dad was a Count, but her mother was a servant’s daughter. Like in fairytales, Christina and Arthur married against all the odds, and later all those people who were against this marriage became frequenters of their dancing routes in this building by architect Arthur Meinig. Now the Central Library is one of the best places in the city to spend some hours reading a book and having a cup of coffee in an outstanding, fairytale, almost Disney-ish environment.",
        "5"),
    MapPoint(4,"Szabó Ervin tér", 47.501315, 19.084969,
        "One of the characters of the mural is holding an object in her hand that will remind you of a prism. What is she holding in the other hand?.",
        "Murals of the Eastern Station was painted by two artists, Károly Lotz and Than Mór. Lotz is a famous Hungarian artist of German descent. You can find his frescoes in the interiors of all the most important buildings of Budapest - the Opera and Parliament, the basilica of St. Stephen and the Ethnographic Museum. Tan More was more engaged in easel painting. His most famous work is \"The Battle of Mohach\" (it is interesting that it was painted when he lived in Paris).",
        "The Bridge"),
    MapPoint(5,"Szent István park", 47.519132, 19.050947,
        "How many human ears are there on the sculpture and the pedestal altogether?",
        "Here stands a monument to Raoul Wallenber — a legend man, who saved thousands of hungarian jews in 1944th. Born in a wealthy Swedish aristocratic family, Raoul got the superioir edication, he spoke several european languages and travelled the world. HIs powerfull granddad wanted him to be a banker or a business person, but Raoul didn't see himself as a moneymaker. During the World War II he emerged in Budapest with the mission to save lives of jewish people. He was always surrounded by wide range of of military men of all sorts, spies, Nazis, politicians and opportunists, dealers and fortune hunters. To accomplish his mission he used all means from bribery to pseudo-official Sweden documents for people from ghetto. He even bought and rented up to 30 houses in Budapest and declared them an Embassy compounds so that jews could live there. In 1945 he disappeared somewhere in Moscow prisons and believed to be killed in 1947th.",
        "3"),
    MapPoint(6,"Práter utca, 11", 47.512684, 19.080327,
        "Monument to the characters of “The Paul Street Boys” (“A Pál utcai fiúk”)\n" +
                "Year of the monument installation",
        "First published in 1906, “The Paul Street Boys” by Ferenc Molnar became one of the most popular Hungarian children's books in the world. There is probably no Hungarian who has not read it. One of the novel's film adaptations was nominated for the Academy Award for the Best Foreign Language Film in 1969.",
        "2007"),
    MapPoint(7,"The Timewheel (Időkerék)", 47.48667, 19.072282,
        "Plaques with descriptions of the monument to the right of the hourglass. Quote used in the description\n" +
                "Author of the quote",
        "The Timewheel (Időkerék) is one of the world's largest hourglasses: sand trickles down from the top to the bottom through a small opening in the glass. At the end of each year the wheel is supposed to be turned 180 degrees, which must be done by manual power using steel cables and it takes roughly 45 minutes. Since 2011 (circa) The Timewheel is broken.",
        "Agoston"),
    MapPoint(8,"Entrance to Vörösmarty utca metro station (direction from the city centre)", 47.507287, 19.066612,
        "Bench near the metro entrance\n" +
                "Musical instrument",
        "Opposite this checkpoint is one of the most famous museums of Budapest — the House of Terror (Terror Háza), the former Hungarian State Security Service. It contains exhibits related to the fascist and communist regimes in 20th-century Hungary and is also a memorial to their victims.",
        "Piano")
)

