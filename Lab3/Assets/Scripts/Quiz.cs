using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;
using UnityEngine.SceneManagement;

public class Quiz : EventTrigger
{
    public Config config = Config.Instance;
    public int numQuestions = 5;
    private int currentQuestion = 0;
    private string[] questions = {"Who is the main professor for Charms?", "Which spell is used to levitate objects?", "The muffliato charm is used to _____", "Which spell is used to gouge out specific areas of material?",
                                    "Immobulus is used to ____", "Who was the main professor for Transfiguration?", "The incantation to transform an animal into a water goblet is ___",
                                    "Draconifors is an incantation used to ___", "What is the incantation for conjuring a bouquet of flower", "Avis is an incantation used to ___",
                                    "In Harry Potter’s first year, what was the name of DADA’s current professor?", "In what year of the curriculum are Demetors introduced?", 
                                    "Which Death Eater assumed the role of Professor during Voldemort’s rule?",
                                    "Counter-curses were taught in what year (but are also discouraged)?", 
                                    "Salvio-Hexia is what type of enchantment? ", "The name of the most current potions professor is ____",
                                    "The Wiggenweld potion is used to __ ", "Which powerful plant is used in potions AND can counteract enchantments?",
                                    "The “luck” potion is known as ___", "What is the name of the antidote that is taken from a goat?",
                                    "During Harry Potter’s year, what is the name of the professor?", "The name of the human-like plant that produces a fatal cry is called a ____",
                                    "What is the name of the spell that increases the growth rate of plants?", "Which healing plant is also used in potions?",
                                    "Gillyweed allows the eater to ___"};            
    private string[] rounds = {"Round 1: Charms", "Round 2:  Transfiguration", "Round 3: Defence Against the Dark Arts", "Round 4: Potions", "Round 5: Herbology"};
    private int[] answers = {0, 1, 1, 2, 0, 1, 0, 1, 3, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 2, 1, 3, 1, 0, 0};
    private string[,] options =  {{"Filius Flitwick", "Trelawney", "Severus Snape", "Horace Slughorn"},
                                {"Alarte Ascendare", "Wingardium Leviosa", "Oppugno", "Wingardi Mobulus"},
                                {"Muffle the target’s voice until someone counters it", "Fill the ears of the targets with a buzzing noise", "Blurs the target’s vision", "Numbs all the senses for 3 hours"},
                                {"Impedimentae", "Reducio", "Defodio", "Mobiliarbus"},
                                {"Immobilize a living target", "Immobilize any target", "Mobilize a vehicle", "Slow down a target"},
                                {"Cuthbert Binns", "Minerva McGonagall", "Sybill Trelawney", "Firenze"},
                                {"Vera Verto", "Melofors Vera", "Avifors", "Evanesco"},
                                {"Conjures thorns on an inanimate object", "Turns statues/small objects into fire-breathing dragons", "Gives the human target fire-breath and dragon-like features", "None of the above"},
                                {"Multicorfors", "Herbifors", "Orchifors", "Orchideous"},
                                {"Transforms statues/small objects into birds", "Conjures birds from the wand", "Gives the caster the ability to fly", "Shoots arrows from the wand"},
                                {"Quirinus Quirrell", "Gilderoy Lockhart", "Remus Lupin", "Dolores Umbridge"},
                                {"Fourth year", "Sixth Year", "Third Year", "They are never introduced"},
                                {"Amycus Carrow", "Alecto Carrow", "Barty Crouch Jr", "Rabastan Lestrange"},
                                {"Fifth Year", "Sixth Yea", "Fourth year", "They are never taught"},
                                {"Entrancing Enchantment", "Protective Enchantment", "Offensive Enchantment", "Senses Enhancement"},
                                {"Severus Snape", "Horace Slughorn", "Draco Malfoy", "Alastor “Mad-Eye” Moody"},
                                {"Heal; Cures injuries", "Heal; Cures headaches", "Make someone dance uncontrollably", "Give prolonged endurance"},
                                {"Bezoar", "Moly", "Valerian", "Dittany"},
                                {"Amortentia", "Felix Felicis", "Invigoration Draught", "Wit-Sharpening Potion"},
                                {"Shrivelfig", "Aconite", "Bezoar", "Sopophorous Bean"},
                                {"Sybil Trelawney", "Pomona Sprout", "Talula Binns", "Aurora Sinistra"},
                                {"Moly", "Valerian", "Puffapod", "Mandrake"},
                                {"Lumos Solarum", "Herbivicus Charm", "Incendio Duo", "Severing Charm"},
                                {"Dittany", "Stinksap", "Valerian", "Both A and C"},
                                {"Breathe underwater", "Hold their breath for a certain amount of time", "Have night vision", "Nothing; There are no special properties"}};

    void Update()
    {
        Debug.Log("Rounds " + config.Rounds);
    }
    
    public override void OnPointerClick(PointerEventData data)
    {
        Debug.Log("Next Question called.");
        nextQuestion();
    }

    public void nextQuestion() {
        if (config.Answer == -1) {
            // ERROR
            return;
		}

        Debug.Log(config.Rounds);
        int round = getRound();

        // Reset UI
        ResetColour();

        // Update score
        if (config.Answer == answers[currentQuestion])
            config.Score = config.Score + 1;

        // Move to next question
        currentQuestion++;
        if (round > config.Rounds || currentQuestion >= questions.Length) {
            // Show score
            SceneManager.LoadScene("ScoreScene");
		} else {
            // Update Round
            GameObject.Find("round").GetComponent<Text>().text = rounds[round];

            // Update Question
            GameObject.Find("question").GetComponent<Text>().text = questions[currentQuestion]; 

            // Update options
            GameObject.Find("a").GetComponent<Text>().text = options[currentQuestion, 0]; 
            GameObject.Find("b").GetComponent<Text>().text = options[currentQuestion, 1]; 
            GameObject.Find("c").GetComponent<Text>().text = options[currentQuestion, 2]; 
            GameObject.Find("d").GetComponent<Text>().text = options[currentQuestion, 3]; 

            config.Answer = -1;
        }
	}

    private void ResetColour() {
        GameObject.Find("a").GetComponent<Text>().color = new Color(212/255f, 195/255f, 125/255f, 255/255f);
        GameObject.Find("b").GetComponent<Text>().color = new Color(212/255f, 195/255f, 125/255f, 255/255f);
        GameObject.Find("c").GetComponent<Text>().color = new Color(212/255f, 195/255f, 125/255f, 255/255f);
        GameObject.Find("d").GetComponent<Text>().color = new Color(212/255f, 195/255f, 125/255f, 255/255f);
	}

    private int getRound() {
        return (int) Math.Floor((double)(currentQuestion/5));
	}
}
