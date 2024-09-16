import { useRef } from 'react'

function Questionb() {
    const divRef = useRef<HTMLDivElement>(null);

    const scrollToTop = () => {
      if (divRef.current) {
        divRef.current.scrollTop = 0;
      }
    };
  
    return (
      <div ref={divRef} style={{ height: '400px', overflowY: 'scroll' }}>
      <p> USE REF QUESTION 2    </p>
        <p>
        According to the American Society for the Prevention of Cruelty to Animals (ASPCA), an estimated 78 million dogs are owned as pets in the United States.

It is unclear when dogs were first domesticated, but a studyTrusted Source published last year claims that, at least in Europe, dogs were tamed 20,000–40,000 years ago.

It is likely that humans and dogs have shared a special bond of friendship and mutual support ever since at least the Neolithic period — but why has this bond been so long-lasting?

Of course, these cousins of the wolves have historically been great at keeping us and our dwellings safe, guarding our houses, our cattle, and our various material goods. Throughout history, humans have also trained dogs to assist them with hunting, 
or they have bred numerous quirky-looking species foralso trained dogs to assist them with hunting, or they have bred numerous quirky-looking species for their cuteness or elegance.

However, dogs are also — and might have always been — truly valued companions, famed for their loyalty and seemingly constant willingness to put a smile on their owners’ faces.

In this Spotlight, we outline the research that shows how our dogs make us happier, more resilient when facing stress, and physically healthier, to name but a few ways in which these much-loved quadrupeds support our well-being.
How dogs keep you in good health

Many studies have suggested that having dogs as pets is associated with better physical health, as reviewsTrusted Source of the existing literature show. These findings persist. 
Just last year, Medical News Today reported on a study that showed that owning a dog reduces a person’s risk of premature death by up to a third.

Also, researchers at the University of Harvard in Cambridge, MA, suggest that dog owners have a lower risk of heart disease.

Why is that? It is difficult to establish a causal relationship between owning a dog and enjoying better health.

However, the benefits may appear thanks to a series of factors related to lifestyle adjustments that people tend to make after they decide to adopt a canine friend.

The most prominent such lifestyle factor is physical activity. There is no way around it: if you own a dog, you have to commit to twice daily walks — and sometimes even more.

According to a paperTrusted Source published in The Journal of Physical Activity and Health, dog owners are more likely to walk for leisure purposes than both non-pet owners and people who own pet cats.

The results were based on studying a cohort of 41,514 participants from California, some of whom owned dogs, some of whom owned cats, and some of whom did not have any pets.

Moreover, several recent studies — including one from the University of Missouri in Columbia and another from Glasgow Caledonian University in the United Kingdom — found that adults aged 60 and over enjoy better health thanks to the “enforced” exercise they get by walking their dogs.
Dogs can strengthen our health not just as we grow older, but also much, much earlier than that: before we are even born.

Research published last year suggests that children who were exposed to dogs while still in the womb — as their mothers spent time around dogs during pregnancy — had a lower risk of developing eczema in early childhood.

Also, children exposed to certain bacteria carried by dogs also experienced a reduction of asthma symptoms, the researchers noted.
‘Dogs make people feel good’

Perhaps the most intuitive benefit of sharing your life and home with a canine friend is that dogs give you “feel-good vibes” almost instantly.
         </p>
  
        <button onClick={scrollToTop}>Scroll to Top</button>
      </div>
    );
}

export default Questionb;