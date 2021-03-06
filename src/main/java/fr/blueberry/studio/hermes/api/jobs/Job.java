package fr.blueberry.studio.hermes.api.jobs;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.app.Logger;

/**
 * Job
 */
public abstract class Job {
    
    private final Hermes hermes;
    private final Logger logger;

    public Job() {
        this.hermes = Hermes.getHermes();
        this.logger = hermes.getLogger();
    }
    /**
     * Run the job.
     */
    public abstract void run();

    /**
     * Get Hermes application.
     * @return - Hermes app
     */
    public Hermes getHermes() {
        return this.hermes;
    }

    /**
     * Get the logger of the application.
     * @return - The logger of the application.
     */
    public Logger getLogger() {
        return this.logger;
    }
}
