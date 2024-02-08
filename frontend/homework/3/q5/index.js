const player = {
    firstName: "Leo",
    lastName: "Messi",
    address: {
      country: "Spain",
      city: "Barcelona",
    },
    careerInfo: {
      fcBarcelona: {
        appearances: 780,
        goals: {
          premierLeagueGoals: 590,
          championsLeagueGoals: 50,
        },
      },
    },
  };

  console.log("keys are: ");
  const allKeys = getAllKeys(player);
  console.log(allKeys);
  

  console.log("values are :");
  const allValues = getAllValues(player);
  console.log(allValues);
  

  function getAllKeys(obj) {
    return Object.keys(obj).reduce((keys, key) => {
      if (typeof obj[key] === "object" && obj[key] !== null) {
        return keys.concat(getAllKeys(obj[key]).map(k => `${key}.${k}`));
      } else {
        return keys.concat(key);
      }
    }, []);
  }
  

  function getAllValues(obj) {
    return Object.values(obj).reduce((values, value) => {
      if (typeof value === "object" && value !== null) {
        return values.concat(getAllValues(value));
      } else {
        return values.concat(value);
      }
    }, []);
  }
  