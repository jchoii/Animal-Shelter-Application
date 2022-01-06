<template>
  <div class="aboutUs">
    <div id="derek" class="bio-bubble">
      <h2>Derek Parsons</h2>
      <a href="https://www.linkedin.com/in/derek-parsons" class="linkedin">LinkedIn Profile</a>
      <div><img src="/assets/Derek.jpg" alt="Rosie and Pistachio" id="our-pet-photo"/></div>
      <p id="left">Born in Royal Oak, MI but currently living in Troy, Derek can usually be found these days reading a good sci-fi novel, watching a documentary or an anime on Netflix or playing with his kittens, Primrose (Rosie) and Pistachio (Stachi). 
        He enjoys coding, studying other languages, discussing philosophy, history, cosmology and futurism, and playing City of Heroes with friends. 
        Above are his beloved kitties, Rosie and Stachi.</p>
    </div>
    <div id="jessica" class="bio-bubble">
      <h2>Jessica Choi</h2>
      <a href="https://www.linkedin.com/in/jessica-c-" class="linkedin">LinkedIn Profile</a>
      <div><img src="/assets/Jessica.jpeg" alt="Calvin" id="our-pet-photo"/></div>
      <p id="left">Based in Texas, Jessica is a former HR professional with a passion for learning/coding! 
        Besides her love for coding, she is also a huge animal lover and hopes to adopt a cat one day as well! 
        Above is her dog, Calvin, who loves going on car rides, eating apples, and playing fetch. 
        In her free time, you’ll find Jessica spending time with family/friends, learning how to play the guitar, or trying out a new recipe.</p>
    </div>
    <div id="kyle" class="bio-bubble">
      <h2>Kyle David</h2>
      <a href="https://www.linkedin.com/in/kdavid-dev1192/" class="linkedin">LinkedIn Profile</a>
      <div><img src="/assets/Kyle.jpg" alt="Meeloo" id="our-pet-photo"/></div>
      <p id="left">From the Philippines, to the US, to Germany, Kyle finds himself living in Cleveland with his newfound love of programming nowadays.
        When he's feeling cozy, you'll find him learning a new hobby, playing League of Legends, or sinking into something fantasy or sci-fi. 
        When he's feeling adventurous, you'll find him chasing meteor showers, a good trail, or driving out to the nearby city. Pictured is his cat Meeloo, the lady who greets you with the best headbutts.</p>
    </div>
    <div id="pareesa" class="bio-bubble">
      <h2>Pareesa Madjd</h2>
      <a href="https://www.linkedin.com/in/pmadjd/" class="linkedin">LinkedIn Profile</a>
      <div><img src="/assets/Pareesa.jpg" alt="Cyrus" id="our-pet-photo"/></div>
      <p id="left">Located near Washington D.C., Pareesa has a degree in Marketing with work experience in social media management and quality assurance testing. 
        When she isn’t trying to crack a tricky Java problem, you’ll find her playing video games, experimenting with a new crafting project, or getting bubble tea for the third time this week. 
        Her photo features her beloved childhood cat of almost 18 years, Cyrus the Great.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "aboutUs",
};
</script>

<style>
.aboutUs {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
#left{
  text-align: left;
  display: inline-block;
}
.linkedin{
  font-size: 17px;
}
#our-pet-photo{
  width: 250px;
  height: auto;
  border-radius: 15px;
  margin-top: 10px;
}

.bio-bubble{
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 20vw;
  text-align: center;
  font-size: 120%;
  font-family: Asap;
  /* font-family: 'Nunito Sans', sans-serif; */
  box-sizing: border-box;
  width: auto;
  position: relative;
  clear: both;
  background: white;
  background-image: -webkit-gradient(
    linear,
    left bottom,
    left top,
    color-stop(0.15, white),
    color-stop(1, #95c2fd)
  );
  background-image: -webkit-linear-gradient(bottom, #bee2ff 15%, white 100%);
  background-image: -moz-linear-gradient(bottom, #bee2ff 15%, white 100%);
  background-image: -ms-linear-gradient(bottom, #bee2ff 15%, white 100%);
  background-image: -o-linear-gradient(bottom, #bee2ff 15%, white 100%);
  background-image: linear-gradient(to top, #cbdfec 15%, white 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#95C2FD', endColorstr='#BEE2FF');
  /* border: solid 1px rgba(0,0,0,0.5); */
  border: white;
  -webkit-border-radius: 20px;
  -moz-border-radius: 20px;
  border-radius: 20px;
  -webkit-box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  margin-bottom: 20px;
  margin-top: 20px;
  margin-left: 10px;
  margin-right: 10px;
  padding: 6px 20px;
  color: rgb(37, 47, 126);
  text-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
  word-wrap: break-word;
}
</style>